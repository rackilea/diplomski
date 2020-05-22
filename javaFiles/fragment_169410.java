/*
 * Main.java
 *
 * Copyright (C) 2008 Ville Voutilainen
 * $Id$
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import org.armedbear.lisp.*;

public class Main
{
    /**
     * This example creates an Interpreter instance, loads our
     * lisp code from a file and then looks up a function defined
     * in the loaded lisp file and executes the function. 
     *
     * The function takes a single parameter and invokes a java method
     * on the object provided. We provide our Main object as the parameter.
     *
     */
    public static void main(String[] argv)
    {
    try
        {
        Main thisObject = new Main();
        Interpreter interpreter = Interpreter.createInstance();
        interpreter.eval("(load \"lispfunctions.lisp\")");
        // the function is not in a separate package, thus the
        // correct package is CL-USER. Symbol names are
        // upper case. Package needs the prefix, because java
        // also has a class named Package.
        org.armedbear.lisp.Package defaultPackage = 
            Packages.findPackage("CL-USER");
        Symbol voidsym = 
            defaultPackage.findAccessibleSymbol("VOID-FUNCTION");
        Function voidFunction = (Function) voidsym.getSymbolFunction();
        voidFunction.execute(new JavaObject(thisObject));
        }
    catch (Throwable t)
        {
        System.out.println("exception!");
        t.printStackTrace();
        }
    }
    public int addTwoNumbers(int a, int b)
    {
    return a + b;
    }
}

;;; lispfunctions.lisp
;;;
;;; Copyright (C) 2008 Ville Voutilainen
;;; $Id$
;;;
;;; This program is free software; you can redistribute it and/or
;;; modify it under the terms of the GNU General Public License
;;; as published by the Free Software Foundation; either version 2
;;; of the License, or (at your option) any later version.
;;;
;;; This program is distributed in the hope that it will be useful,
;;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;;; GNU General Public License for more details.
;;;
;;; You should have received a copy of the GNU General Public License
;;; along with this program; if not, write to the Free Software
;;; Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

; we need to get the
; 1) class (Main)
; 2) classes of the parameters (int)
; 3) method reference (getting that requires the class
; of our object and the classes of the parameters

; After that we can invoke the function with jcall,
; giving the method reference, the object and the parameters.
; The result is a lisp object (no need to do jobject-lisp-value), 
; unless we invoke the method
; with jcall-raw. 
(defun void-function (param)
  (let* ((class (jclass "Main"))
     (intclass (jclass "int"))
     (method (jmethod class "addTwoNumbers" intclass intclass))
     (result (jcall method param 2 4)))
    (format t "in void-function, result of calling addTwoNumbers(2, 4): ~a~%" result)))
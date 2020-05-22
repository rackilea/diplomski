/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pdfboxpageimageextraction;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;

/**
 * This example will take a PDF document and print all the fields from the file.
 *
 * @author Ben Litchfield
 *
 */
public class PrintJavaScriptFields
{

    /**
     * This will print all the fields from the document.
     *
     * @param pdfDocument The PDF to get the fields from.
     *
     * @throws IOException If there is an error getting the fields.
     */
    public void printFields(PDDocument pdfDocument) throws IOException
    {
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();

        //System.out.println(fields.size() + " top-level fields were found on the form");
        for (PDField field : fields)
        {
            processField(field, "|--", field.getPartialName());
        }
    }

    private void processField(PDField field, String sLevel, String sParent) throws IOException
    {
        String partialName = field.getPartialName();

        if (field instanceof PDTerminalField)
        {
            PDTerminalField termField = (PDTerminalField) field;
            PDFormFieldAdditionalActions fieldActions = field.getActions();
            if (fieldActions != null)
            {
                System.out.println(field.getFullyQualifiedName() + ": " + fieldActions.getClass().getSimpleName() + " js field actionS:\n" + fieldActions.getCOSObject());
                printPossibleJS(fieldActions.getK());
                printPossibleJS(fieldActions.getC());
                printPossibleJS(fieldActions.getF());
                printPossibleJS(fieldActions.getV());
            }
            for (PDAnnotationWidget widgetAction : termField.getWidgets())
            {
                PDAction action = widgetAction.getAction();
                if (action instanceof PDActionJavaScript)
                {
                    System.out.println(field.getFullyQualifiedName() + ": " + action.getClass().getSimpleName() + " js widget action:\n" + action.getCOSObject());
                    printPossibleJS(action);
                }
            }
        }

        if (field instanceof PDNonTerminalField)
        {
            if (!sParent.equals(field.getPartialName()))
            {
                if (partialName != null)
                {
                    sParent = sParent + "." + partialName;
                }
            }
            //System.out.println(sLevel + sParent);

            for (PDField child : ((PDNonTerminalField) field).getChildren())
            {
                processField(child, "|  " + sLevel, sParent);
            }
        }
        else
        {
            String fieldValue = field.getValueAsString();
            StringBuilder outputString = new StringBuilder(sLevel);
            outputString.append(sParent);
            if (partialName != null)
            {
                outputString.append(".").append(partialName);
            }
            outputString.append(" = ").append(fieldValue);
            outputString.append(", type=").append(field.getClass().getName());
            //System.out.println(outputString);
        }
    }

    private void printPossibleJS(PDAction kAction)
    {
        if (kAction instanceof PDActionJavaScript)
        {
            PDActionJavaScript jsAction = (PDActionJavaScript) kAction;
            String jsString = jsAction.getAction();
            if (!jsString.contains("\n"))
            {
                // avoid display problems with netbeans
                jsString = jsString.replaceAll("\r", "\n").replaceAll("\n\n", "\n");
            }
            System.out.println(jsString);
            System.out.println();
        }
    }

    /**
     * This will read a PDF file and print out the form elements. <br />
     * see usage() for commandline
     *
     * @param args command line arguments
     *
     * @throws IOException If there is an error importing the FDF document.
     */
    public static void main(String[] args) throws IOException
    {
        PDDocument pdf = null;
        try
        {
            pdf = PDDocument.load(new File("XXXX", "YYYYY.pdf"));
            PrintJavaScriptFields exporter = new PrintJavaScriptFields();
            exporter.printFields(pdf);
        }
        finally
        {
            if (pdf != null)
            {
                pdf.close();
            }
        }
    }

}
package org.xtext.example.mydsl

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.xtext.example.mydsl.myDsl.Model

class Sample {

    def static void main(String[] args) {
        val userInput = '''
        model x {
            a = 1
            b = 1 + 2
            c = "Hello"
        }
        '''
        val injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration
        val resourceSet = injector.getInstance(ResourceSet)
        val resource = resourceSet.createResource(URI.createURI("dummy.mydsl"))
        resource.load(new StringInputStream(userInput), null)
        val model = resource.contents.head as Model
        val interpreter = injector.getInstance(XbaseInterpreter)
        for (g : model.expressions) {
            val ctx = new DefaultEvaluationContext
            val result = interpreter.evaluate(g.body, ctx, CancelIndicator.NullImpl)
            println(result.result)
        }
    }

}
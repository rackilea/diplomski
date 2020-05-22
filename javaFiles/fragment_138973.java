package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Injector
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetup
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelFactory
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder

class Main {
    var static extension DomainmodelFactory factory = DomainmodelFactory.eINSTANCE

    def static void main(String[] args) {
        var Injector injector = new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration()
        val ResourceSet resourceSet = injector.getInstance(ResourceSet)
        val Resource r0 = resourceSet.createResource(URI.createURI("base/Base.dmodel"))
        val Resource r1 = resourceSet.createResource(URI.createURI("model/Person.dmodel"))
        val typeReferenceBuilder = injector.getInstance(JvmTypeReferenceBuilder.Factory).create(resourceSet)
        val typeReferences = injector.getInstance(TypeReferences)
        val model = createDomainModel
        r1.contents += model
        val model0 = createDomainModel
        r0.contents += model0
        // build the ast using xtends with clause
        model0 => [
            elements += createPackageDeclaration => [
                name = "base"
                elements += createEntity => [
                    name = "Base"
                    features+= createProperty => [
                        name = "id"
                        type = typeReferenceBuilder.typeRef("java.lang.String")
                        println(type)
                    ]
                ]
            ]
        ]
        //trigger the inferrer on resource 0
        (r0 as DerivedStateAwareResource) => [
            fullyInitialized = false
            installDerivedState(false)
        ]

        // build the ast of the second resource
        model => [
            elements += createPackageDeclaration => [
                name = "model"
                elements += createEntity => [
                    val base = typeReferences.findDeclaredType("base.Base", resourceSet)
                    println(base)
                    superType = typeReferenceBuilder.typeRef(base) as JvmParameterizedTypeReference
                    println(superType)

                    name = "Person"
                    features+= createProperty => [
                        name = "name"
                        type = typeReferenceBuilder.typeRef("java.lang.String")
                        println(type)
                    ]
                ]
            ]
        ]
        //save the resources
        r0.save(SaveOptions.defaultOptions.toOptionsMap)
        r1.save(SaveOptions.defaultOptions.toOptionsMap)
    }

}
.method public hidebysig newslot virtual instance void M(class X x) cil managed
{
    .maxstack 8
    L_0000: ldarg.0 
    L_0001: call instance class [mscorlib]System.Type [mscorlib]System.Object::GetType()
    L_0006: call void [mscorlib]System.Console::WriteLine(object)
    L_000b: ldarg.1 
    L_000c: ldarg.0 
    L_000d: callvirt instance void X::XMethod(class A)
    L_0012: ret 
}
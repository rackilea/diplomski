namespace: ie.ondevice
{
    use: ie.ondevice.lang.Mixin;
    use: ie.ondevice.TraitsDeclaration;

    declare: Example < Mixin | TraitsDeclaration
    {
        include: "path/to/file.extension";
        // implementation here
    }
}
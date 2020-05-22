label:
{
    for(Foo f : AppleList) if(!f.slotted) break label;

    // Here you guaranteed that all slotted fields are true
}
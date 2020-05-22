for(Parent parent : parentList)
{
    if(parent instanceof SubclassA)
    {
        SubclassA subclass = (SubclassA)parent;
        extractMe.add(subclass);
    }
}
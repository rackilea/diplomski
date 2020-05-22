class ReferenceParentController {

    @ModelAttribute("refs")
    public List getRef() {
       ...
    }

    @ModelAttribute("refs2")
    public List getRef2() {
       ...
    }
}

class Create extends ReferenceParentController  {
    ...
}

class Edit extends ReferenceParentController  {
    ...
}
if (selectedElements.size() > 0):
    for c in selectedElements:
        print "<?php"
        print ""
        print "class " + c.getName()
        print "{"

        child = c.getCompositionChildren()       
        for a in child:
            if (a.getMClass().getName() == "Operation"):             
                print " public function " + a.getName() + "()"
                print " {"
                print " }"
                print ""                     
        print "}"
        print ""
else:
    print "No element has been selected."
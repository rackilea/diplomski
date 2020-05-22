textpop-up
import re
p = re.compile(r'^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=\[\]{};\':"\\|,.<>\/?]).*$', re.MULTILINE | re.VERBOSE)
str = "nonumbersSOITFAILS\nalllowercasesoitfails\nALLUPPERCASESOITFAILS\n111111111111111111111\n1alllowercasesoitfails\nALLUPPERCASESOITFAILS1\n1Aa%\n1%UPPERCASElowercasenumberandspecialcharacter\n1%UPPERCASElowercase spacetoo\n\n\n"

re.findAll(p, str)
#macro(displayNode $node)
{
    "name" = "$node.name",
    "value" = "$node.value"##
    #if ($node.childrens.size() > 0),
    "childrens" = {
        #foreach ($child in $node.children)
            #displayNode($child)
        #end
    }
    #end
}
#end
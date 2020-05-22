<o:tree id="tree" value="#{treeBean.tree}" var="exampleEntity" varNode="node">
    <o:treeNode>
        <ul>
            <o:treeNodeItem>
                <li>
                    <h:selectBooleanCheckbox value="#{exampleEntity.value}" />
                    <o:treeInsertChildren />
                </li>
            </o:treeNodeItem>
        </ul>
    </o:treeNode>
</o:tree>
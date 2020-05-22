<rule ref="rulesets/java/comments.xml/CommentRequired">
    <properties>
        <property name="violationSuppressXPath" value="//ClassOrInterfaceBodyDeclaration/MethodDeclaration/MethodDeclarator[matches(@Image,'(get|is|set)[\p{Lu}].*') and not(FormalParameters/FormalParameter)]"/>
        <property name="fieldCommentRequirement" value="Ignored"/>
    </properties>
</rule>
<util:map id="fruit">
    <entry key="banana" value="#{89.7}"/>
    <entry key="apple" value="efg"/>
    <entry key="orange" value="lmn"/>
</util:map>
<bean id="hello" class="com.choiwan.Hello">
    <property name="name" value="#{(fruit['banana']+'').contains('89')?'Monkey':'Banana'} kind of file"/>
</bean>
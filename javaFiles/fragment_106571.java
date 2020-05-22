public class MessageFactoryBean implements FactoryBean<MessageInterface> {

    private MessageInterface postcard;
    private MessageInterface letter;

    public MessageInterface getObject() {
        if (your condition here) {
            return letter;
        }
        return postcard;
    }
    // other methods omitted
}

<beans ...>
    <bean id="messageBean" class="MessageFactoryBean">
        <property name="postcard">
            <bean class="PostcardBean" />
        </property>
        // other properties omitted
    </bean>

    <bean id="helloWorld" class="com.askQuestion.HelloWorld">
        <property name="message" ref="messageBean"/>
    </bean>    
</beans>
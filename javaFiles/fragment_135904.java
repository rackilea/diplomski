@RequestMapping(...)
public @ResponseBody User myMethod(Model model){
    return user;
}

<mvc:annotation-driven conversion-service="conversionService"> 
   <mvc:message-converters register-defaults="false"> <!-- you may have to explicitly register other converters though-->
       <bean class="org.springframework.http.converter.xml.MarshallingHttpMessageConverter">
           <property name="marshaller">
               <bean class="org.springframework.oxm.xstream.XStreamMarshaller"/>
           </property>
       </bean>
   </mvc:message-converters>
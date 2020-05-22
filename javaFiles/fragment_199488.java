<bean class="org.springframework.batch.item.file.FlatFileItemWriter" scope="step">
   <property name="headerCallback">
       <bean class="xx.xx.xx.CustomHeaderWriter">
           <property name="header" value="${columns.or.aliases}"></property>
        </bean>
   </property>
</bean>
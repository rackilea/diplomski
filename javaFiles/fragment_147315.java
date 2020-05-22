<tabpanel>
            <listbox id="usersList" sizedByContent="true" span="true" model="${users}">
                <listhead>
                    <listheader label="User Name"/>
                    <listheader label="gender"/>
                </listhead>
                <template name="model" var="user"> 
                    <listitem>
                        <listcell label="${user.userName}"/>    
                        <listcell label="${user.gender}"/>
                    </listitem>   
                </template>
            </listbox>
        </tabpanel>
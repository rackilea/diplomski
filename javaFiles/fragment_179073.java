<Window title="Hello" maximized="true"
    xmlns:wtkx="http://pivot.apache.org/wtkx"
    xmlns="org.apache.pivot.wtk">
    <content>
        <BoxPane styles="{padding:4, horizontalAlignment:'center', verticalAlignment:'center'}">
            <Label wtkx:id="label1" text="Please enter your name"
              styles="{font:'Arial 20', color:'#ff0000',
                  horizontalAlignment:'center', verticalAlignment:'center'}"/>
              <TextInput wtkx:id="text1"  /> 
              <PushButton wtkx:id="button1" buttonData="Enter"/>
        </BoxPane>
    </content>
</Window>
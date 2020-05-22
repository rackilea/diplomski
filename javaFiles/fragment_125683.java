<mail enableStartTLS="true" ssl="true" mailhost="smtp.gmail.com" mailport="465" user="apache.ant.alert@gmail.com" password="******" subject="${project} Pushed Live">
        <from address="apache.ant.alert@gmail.com"/>
        <replyto address="apache.ant.alert@gmail.com"/>
        <to address="simon@"/>
        <cc address="andrew@" />
        <message>${project} has successfully been transferred via FTP.</message>
    </mail>
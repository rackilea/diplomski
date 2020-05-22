<route customId="true" id="localRoute">
    <from uri="{{ftp.pull.LOCAL.server}}" />
    <doTry>
        <process ref="Processor" />
        <doCatch><exception>com.myException.ThrownException</exception></doCatch>
    </doTry>
    <to uri="{{ftp.push.LOCAL.route}}" />
</route>
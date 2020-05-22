<camel:route id="splitter_test">
    <camel:from uri="file:///home/steppra1/camel_test?delete=true&amp;idempotent=true" />
    <camel:to uri="bean:splitBean?method=init" />
    <camel:split streaming="true">
        <camel:tokenize token="\n" />
        <camel:to uri="bean:splitBean?method=addToken" />
    </camel:split>
    <camel:to uri="bean:splitBean?method=done" />
    <camel:log message="${in.body}" loggingLevel="INFO" logName="split_test" />
</camel:route>
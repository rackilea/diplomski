<Appenders>
    <File name="file" fileName="${env:LOG_PATH}">
        <PatternLayout>
            <Pattern>%d %p %c{1.} [%t] %m %ex%n</Pattern>
        </PatternLayout>
    </File>
</Appenders>
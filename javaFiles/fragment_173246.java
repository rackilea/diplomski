package bench;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class MessageBench {

    @Benchmark
    public Message builder() {
        return Message.createNew()
                .email(getString())
                .assignee(getString())
                .conversationId(getString())
                .escalationEmail(getString())
                .subject(getString())
                .userId(getString())
                .create();
    }

    @Benchmark
    public Message immutable() {
        return new Message()
                .email(getString())
                .assignee(getString())
                .conversationId(getString())
                .escalationEmail(getString())
                .subject(getString())
                .userId(getString());
    }

    @Benchmark
    @Fork(jvmArgs = "-XX:-EliminateAllocations")
    public Message immutableNoOpt() {
        return new Message()
                .email(getString())
                .assignee(getString())
                .conversationId(getString())
                .escalationEmail(getString())
                .subject(getString())
                .userId(getString());
    }

    private String getString() {
        return "hello";
    }
}
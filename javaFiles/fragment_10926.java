import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorSystem;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class AkkaTest {

    private ActorSystem system;

    @Before
    public void setup() {
        system = ActorSystem.create("StreamTestKitDocTest");
    }

    @After
    public void shutdown() {
        system.terminate();
    }

    @Test
    public void test() throws InterruptedException, ExecutionException, TimeoutException {

        final Sink<Integer, CompletionStage<Integer>> sinkUnderTest =
        Flow.of(Integer.class)
            .map(i -> i * 2)
            .toMat(Sink.fold(0, (agg, next) -> agg + next), Keep.right());

        final CompletionStage<Integer> future =
        Source.from(Arrays.asList(1, 2, 3, 4)).runWith(sinkUnderTest, system);
        final Integer result = future.toCompletableFuture().get(3, TimeUnit.SECONDS);

        Assert.assertEquals(20, result.intValue());
    }
}
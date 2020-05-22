import static java.util.concurrent.TimeUnit.*;

...

long MAX_DURATION = MILLISECONDS.convert(20, MINUTES);

long duration = now.getTime() - previous.getTime();

if (duration >= MAX_DURATION) {
    ...
}
#!/bin/bash
{
    java examples.Example >/some/place.log &
    echo $!
    wait $!
} | {
    sleep 10
    kill $(read PID; echo $PID)
}
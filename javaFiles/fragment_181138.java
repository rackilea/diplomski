executor.scheduleAtFixedRate(task, delay, delay,
            TimeUnit.MILLISECONDS); // moveing
    executor.scheduleAtFixedRate(task2, delay2, delay2,
            TimeUnit.MILLISECONDS); // spawning new enemies

    System.out.println("Game started, window width: " + getWidth() + ", height: " + getHeight());

    run();
}
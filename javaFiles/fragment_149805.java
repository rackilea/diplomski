public void loopButton() {
    for(int i = 0; i < 1000; i++) {
        for(int i = 0; i < targets.size(); i++) {
            Target t = targets.get(i); 
            findButton(t);
        }
        sleep();
    }
}

public void findButton(Target t) {
    try {
        ScreenRegion flix = fullScreen.find(t);
        ScreenRegion found = fullScreen.wait(t,5000);
        mouse.click(found.getCenter());
        System.out.println("Found");
    } catch(NullPointerException e) {
        System.out.println(e.getMessage());
    }
}
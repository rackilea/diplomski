public static void clearInstance() {
    instance = null;
}

@Override
public void handleEvent(Event e) {
    switch (e.type) {
        case SWT.Dispose: {
            if (e.widget == getComposite()) {
                MyClass.clearInstance();
            }
       break;
         }
    }
}
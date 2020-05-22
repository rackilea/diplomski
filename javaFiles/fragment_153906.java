backgroundHandler yellowBackgroundHandlerObject = new yellowBackgroundHandler();
backgroundHandler blackBackgroundHandlerObject = new blackBackgroundHandler();
backgroundHandler blueBackgroundHandlerObject = new blueBackgroundHandler();

public ChangeFontColorApplicationController(ChangeFontColorApplicationView changeFontColorApplicationViewObject){
    this.changeFontColorApplicationViewObject = changeFontColorApplicationViewObject;

    yellowBackgroundHandlerObject.setNextHandlerInChain(blackBackgroundHandlerObject);
    blackBackgroundHandlerObject.setNextHandlerInChain(blueBackgroundHandlerObject);

    this.changeFontColorApplicationViewObject.addButtonActionListener();
}
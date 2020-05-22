backgroundHandler yellowBackgroundHandlerObject = new yellowBackgroundHandler();
backgroundHandler blackBackgroundHandlerObject = new blackBackgroundHandler();
backgroundHandler blueBackgroundHandlerObject = new blueBackgroundHandler();

public ChangeFontColorApplicationController(ChangeFontColorApplicationView changeFontColorApplicationViewObject){
    this.changeFontColorApplicationViewObject = changeFontColorApplicationViewObject;
    this.yellowBackgroundHandlerObject = new yellowBackgroundHandler(this.changeFontColorApplicationViewObject);
    this.blackBackgroundHandlerObject = new blackBackgroundHandler(this.changeFontColorApplicationViewObject);
    this.blueBackgroundHandlerObject = new blueBackgroundHandler(this.changeFontColorApplicationViewObject);

    yellowBackgroundHandlerObject.setNextHandlerInChain(blackBackgroundHandlerObject);
    blackBackgroundHandlerObject.setNextHandlerInChain(blueBackgroundHandlerObject);

    this.changeFontColorApplicationViewObject.addButtonActionListener(this.changeFontColorApplicationViewObject);
}
@implementation MyPlugin

- (void) myAction:(CDVInvokedUrlCommand*)command {
    NSString* myString = @"Some string";

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:myString];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
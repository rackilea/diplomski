//IMPORTANT - THIS LINE IS ONLY FOR TESTING PURPOSES!
//This code is for accepting self-signed server certificate
ServicePointManager.ServerCertificateValidationCallback += (sender_ws, cert, chain, sslPolicyErrors) => true;

//instantiate transport binding element, leave the defaults
HttpsTransportBindingElement transport = new HttpsTransportBindingElement();

//instantiate message encoding element, where message version must be Soap11WSAddressing10 to match metro web service requirement.
TextMessageEncodingBindingElement text = new TextMessageEncodingBindingElement();
text.MessageVersion = MessageVersion.Soap11WSAddressing10;

//instantiate transport security binding element, with all the suggested values in app.config
TransportSecurityBindingElement b_element = new TransportSecurityBindingElement();
b_element.DefaultAlgorithmSuite = new Basic128SecurityAlgorithmSuite();
b_element.IncludeTimestamp = true;
b_element.KeyEntropyMode = SecurityKeyEntropyMode.CombinedEntropy;
b_element.MessageSecurityVersion = MessageSecurityVersion.WSSecurity11WSTrustFebruary2005WSSecureConversationFebruary2005WSSecurityPolicy11;
b_element.SecurityHeaderLayout = SecurityHeaderLayout.Lax;

//instantiate the custom binding and add the elements created above
CustomBinding customBinding = new CustomBinding();
customBinding.Name = "myOwnPersonalCustomBinding";
customBinding.Elements.Add(b_element);
customBinding.Elements.Add(text);
customBinding.Elements.Add(transport);

//instantiate the client

Uri uri = new Uri("https://localhost:8181/test/hello");
HelloWebServiceClient  wsClient = new HelloWebServiceClient (customBinding, new EndpointAddress(uri));
//Call
richTextBox1.Text = wsClient.hello(textBox1.Text);
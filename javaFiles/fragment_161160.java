AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
[manager.requestSerializer setValue:authValue forHTTPHeaderField:@"Authorization"];
[manager.requestSerializer setValue:@"Mozilla/5.0" forHTTPHeaderField:@"User-Agent"];

NSData *data = [@"facture.jpg" dataUsingEncoding:NSUTF8StringEncoding];
[manager POST:urlTreat parameters:processJson constructingBodyWithBlock:^(id<AFMultipartFormData> formData) {
    [formData appendPartWithFileData:data name:@"facture.jpg" fileName:@"facture.jpg" mimeType:@".jpg"];
} success:^(NSURLSessionTask *operation, id responseObject) {
    NSLog(@"Success: %@", responseObject);
    processId = [responseObject valueForKey:@"processId"];
} failure:^(NSURLSessionTask *operation, NSError *error) {
    NSLog(@"Error: %@", error);
}];
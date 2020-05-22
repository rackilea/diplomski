NSArray *views = [[[UIApplication sharedApplication] keyWindow] subviews];
UIView *_currentView = views[0];

UIImagePickerController *picker = [[UIImagePickerController alloc] init];
picker.delegate = self;
picker.sourceType = UIImagePickerControllerSourceTypeCamera;

[_currentView.window addSubview:picker.view];
@Component(modules = {
    NetModule.class, StaticDataModule.class
}) public interface FirstComponent {
  void inject(WhateverYouWantActivity activity);
}

@Component(modules = {
    NetModule.class, StatusModule.class
}) public interface FirstComponent {
  void inject(WhateverYouWantSecondActivity activity);
}
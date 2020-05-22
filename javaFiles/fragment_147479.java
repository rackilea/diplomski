<!--
 Copyright 2016 The Android Open Source Project

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
-->
<!-- WebView providers in order of preference -->
<!--
 Signature checks are ignored if the package is preinstalled or if this is a userdebug or eng
    build. If no signature is provided, the package can provide a WebView implementation only on userdebug/eng builds or if it's preinstalled 
-->
<webviewproviders>
<webviewprovider description="Chrome Stable" packageName="com.android.chrome" availableByDefault="true">
<!--
 Ignore this package on user/release builds unless preinstalled. 
-->
</webviewprovider>
<!-- The default WebView implementation -->
<webviewprovider description="Android WebView" packageName="com.android.webview" availableByDefault="true"> </webviewprovider>
</webviewproviders>
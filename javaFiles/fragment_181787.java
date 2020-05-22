% security unlock-keychain -p passwordhere codesigning.keychain
% find my-app.app -type f \
  -not -path "*/Contents/runtime/*" \
  -not -path "*/Contents/MacOS/my-app" \
  -not -path "*libapplauncher.dylib" \
  -exec codesign --timestamp --entitlements /tmp/bliss.entitlements -s "XXX" --prefix com.myapp. --options runtime -v --keychain /path/to/codesigning.keychain {} \;

% find my-app.app/Contents/runtime -type f \
  -not -path "*/legal/*" \
  -not -path "*/man/*" \
  -exec codesign -f --timestamp --entitlements /tmp/bliss.entitlements -s "XXX" --prefix com.myapp. --options runtime -v --keychain /path/to/codesigning.keychain {} \;

% codesign -f --timestamp --entitlements /tmp/bliss.entitlements -s "XXX" --prefix com.myapp. --options runtime -v --keychain /path/to/codesigning.keychain my-app.app/Contents/runtime

% codesign -f --timestamp --entitlements /tmp/bliss.entitlements -s "XXX" --prefix com.myapp. --options runtime -v --keychain /path/to/codesigning.keychain my-app.app
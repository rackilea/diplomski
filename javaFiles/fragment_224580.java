osx-keychain-java$ jshell -cp ./dist/osxkeychain.jar

jshell> import com.mcdermottroe.apple.*;
jshell> OSXKeychain keychain = OSXKeychain.getInstance();
keychain ==> com.mcdermottroe.apple.OSXKeychain@2286778

jshell> keychain.addGenericPassword("aardvark", "a", "b");

jshell> keychain.findGenericPassword("aardvark", "a");
$4 ==> "b"
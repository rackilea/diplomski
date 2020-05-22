private StringBuilder mComposing = new StringBuilder();
private static HashMap<Integer, CodeInfo> mCodeMap = new HashMap<Integer, CodeInfo>();

private static class CodeInfo {
   final Character mCode;
   final Map<Character, Character> mCombinedCharMap;

   CodeInfo(Character code, Map<Character, Character> combinedCharMap) {
       mCode = code;
       mCombinedCharMap = combinedCharMap;
   }
}

static {
    //reminder, do not input combinedCharMap as null

    mCodeMap.put(83, new CodeInfo(Character.valueOf((char)4656), new HashMap<Character, Character>());
    HashMap<Character, Character> combinedCharMap = new HashMap<Character, Character>();
    combinedCharMap.put(Character.valueOf('ሰ'), Character.valueOf((char)4659))
    mCodeMap.put(65, new CodeInfo(null, combinedCharMap);
}

@Override 
public void onStartInput(EditorInfo attribute, boolean restarting) {
    super.onStartInput(attribute, restarting);
    mComposing.setLength(0);


    //other codes you already have
}       

public void onKey(int primaryCode, int[] keyCodes) {
    InputConnection ic = getCurrentInputConnection();

    CodeInfo codeInfo = mCodeMap.get(primaryCode);
    Character output = null;
    if (codeInfo != null) {
        if (mComposing.length() > 0) {
            Character combinedOutput = codeInfo.mCombinedCharMap.get(mComposing.charAt(0));
            if (combinedOutput != null) {
                //the length is mComposing is expected to be 1 here
                mComposing.setCharAt(0, combinedOutput);
                ic.finishComposingText();
                ic.setComposingText(mComposing, 1);
                return;
            }
        }
        output = codeInfo.mCode;        
    }
    if (mComposing.length() > 0) {
       mComposing.setLength(0);
       ic.finishComposingText();
    }
    mComposing.append(output==null?(char)primaryCode:(char)output);
    ic.setComposingText(mComposing, 1);
}
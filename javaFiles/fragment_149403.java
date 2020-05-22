public class Property {
      private String mName;
      private int mValue;
      private String mActivation;
      private int mActivationValue;
      private int mInitialValue;

      public Property(String theName, int theInitialValue, String theActivation, int theActivationValue) {
        mName = theName;
        mActivation = theActivation;
        mActivationValue = theActivationValue;
        mInitialValue = theInitialValue;
      }

      public int getValue() {
          return mValue;
      }

      public void setValue(int n) {
          mValue = n;
      }

      public boolean isActive() {
          boolean aRet = false;
          switch(mActivation) {
              case Achieve.ACTIVE_IF_GREATER_THAN: aRet = mValue > mActivationValue; break;
              case Achieve.ACTIVE_IF_LESS_THAN: aRet = mValue < mActivationValue; break;
              case Achieve.ACTIVE_IF_EQUALS_TO: aRet = mValue == mActivationValue; break;
          }

          return aRet;
      }

      public String getActivation() {
          return mActivation;
      }
}


import java.util.ArrayList;

public class Achievement {
  private String mName; // achievement name
  private ArrayList<String> mProps; // array of related properties
  private boolean mUnlocked; // achievement is unlocked or not

  public Achievement(String theId, ArrayList<String> theRelatedProps) {
    mName = theId;
    mProps = theRelatedProps;
    mUnlocked = false;
  }

  public boolean isUnlocked() {
      return mUnlocked;
  }

  public void setUnlocked(boolean b) {
      mUnlocked = b;
  }

  public ArrayList<String> getProps() {
      return mProps;
  }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Achieve {
  // activation rules
  public static final String ACTIVE_IF_GREATER_THAN = ">";
  public static final String ACTIVE_IF_LESS_THAN = "<";
  public static final String ACTIVE_IF_EQUALS_TO = "==";

  private HashMap<String,Property> mProps; // dictionary of properties
  private HashMap<String,Achievement> mAchievements; // dictionary of achievements

  public Achieve() {
      mProps = new HashMap<String,Property>();
      mAchievements = new HashMap<String,Achievement>();
  }

  public void defineProperty(String theName, int theInitialValue, String theaActivationMode, int theValue) {
      mProps.put(theName, new Property(theName, theInitialValue, theaActivationMode, theValue));
  }

  public void defineAchievement(String theName, ArrayList<String> theRelatedProps) {
      mAchievements.put(theName, new Achievement(theName, theRelatedProps));
  }

  public int getValue(String theProp) {
      Property p = mProps.get(theProp);
      if (p != null) return p.getValue();
      return 0;
  }

  public void setValue(String theProp, int theValue) {
      Property p = mProps.get(theProp);
      if (p == null) return;
       switch(p.getActivation()) {
         case Achieve.ACTIVE_IF_GREATER_THAN:
             theValue = theValue > p.getValue() ? theValue : p.getValue();
             break;
         case Achieve.ACTIVE_IF_LESS_THAN:
             theValue = theValue < p.getValue() ? theValue : p.getValue();
             break;
      }

      p.setValue(theValue);
  }

  public void addValue(ArrayList<String> theProps, int theValue) {
      for (int i = 0; i < theProps.size(); i++) {
        String aPropName = theProps.get(i);
        setValue(aPropName, getValue(aPropName) + theValue);
      }
  }

  public ArrayList<Achievement> checkAchievements() {
      ArrayList<Achievement> aRet = new ArrayList<Achievement>();
      Iterator<Map.Entry<String,Achievement>> it = mAchievements.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String,Achievement> pair = it.next();
        Achievement aAchievement = pair.getValue();
        if (!aAchievement.isUnlocked()) {
          int aActiveProps = 0;
          ArrayList<String> props = aAchievement.getProps();
          for (int p = 0; p < props.size(); p++) {
            Property aProp= mProps.get(props.get(p));
            if (aProp.isActive()) {
              aActiveProps++;
            }
          }

          if (aActiveProps == props.size()) {
            aAchievement.setUnlocked(true);
            aRet.add(aAchievement);
          }
        }
      }
      return aRet;
    }
}
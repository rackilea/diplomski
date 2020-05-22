List<String> nStatusValueForcStatutPen = Arrays.asList("ACT", "SUS", "PEN_CAN");
List<String> nStatusValueForcStatutAct = Arrays.asList("SUS", "PEN_CAN");
...
if (!((cStatus.equals(PEN) && nStatusValueForcStatutPen.contains(nStatus))
    || (cStatus.equals(ACT) && nStatusValueForcStatutAct.contains(nStatus))
   ...
}
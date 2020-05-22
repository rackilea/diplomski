class FormatInfo {
    int from;
    int to;
    int formatCode; // <-- e.g. 1 = bold, 2 = italic etc. 
} 

class FormattedNote extends Note {
    List<FormatInfo> formatInfos = new ArrayList<>();

}
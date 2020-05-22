import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VidArchive implements TimeRange<VidArchive, VidArchive.Builder> {
  /** date format used to convert Date objects to human-readable form for the toString() function */
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

  private final byte[] bytes;
  private final String cam;
  private final Date startDate;
  private final Date endDate;
  private final String fileName;
  private final String directory;
  private Builder builder;

  @Override
  public Builder Builder() {
    return builder;
  }

  public static class Builder implements TimeRangeBuilder<VidArchive> {
    private byte[] bytes;
    private String cam;
    private Date startDate;
    private Date endDate;
    private String fileName;
    private String directory;
    public Builder() {}
    public Builder bytes(byte[] bytes)          { this.bytes = bytes;           return this;    }
    public Builder cam(String cam)              { this.cam = cam;               return this;    }
    @Override
    public Builder startDate(Date startDate)    { this.startDate = startDate;   return this;    }
    @Override
    public Builder endDate(Date endDate)        { this.endDate = endDate;       return this;    }
    public Builder fileName(String fileName)    { this.fileName = fileName;     return this;    }
    public Builder directory(String directory)  { this.directory = directory;   return this;    }
    @Override
    public VidArchive build()                   { return new VidArchive(this);                  }
  }



  private VidArchive(Builder builder) {
    this.builder = builder;
    bytes = builder.bytes;
    cam = builder.cam;
    startDate = builder.startDate;
    endDate = builder.endDate;
    fileName = builder.fileName;
    directory = builder.directory;
  }

  public byte[] getBytes()        {   return bytes;       }
  public String getCam()          {   return cam;         }
  @Override
  public Date getStartDate()      {   return startDate;   }
  @Override
  public Date getEndDate()        {   return endDate;     }
  public String getFileName()     {   return fileName;    }
  public String getDirectory()    {   return directory;   }

  @Override
  public int compareTo(VidArchive vidArchive) {
    return startDate.compareTo(vidArchive.getStartDate());
  }

  @Override
  public String toString() {
    return DATE_FORMAT.format(startDate) + " - " + DATE_FORMAT.format(endDate);
  }

}
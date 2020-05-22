import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class PathOffsetWritable implements WritableComparable<PathOffsetWritable> {

    private Text t = new Text();
    private Path path;
    private long offset;

    public PathOffsetWritable(Path path, long offset) {
        this.path = path;
        this.offset = offset;
    }

    public Path getPath() {
        return path;
    }

    public long getOffset() {
        return offset;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        t.readFields(in);
        path = new Path(t.toString());
        offset = in.readLong();
    }

    @Override
    public void write(DataOutput out) throws IOException {
        t.set(path.toString());
        t.write(out);
        out.writeLong(offset);
    }

    @Override
    public int compareTo(PathOffsetWritable o) {
        int x = path.compareTo(o.path);
        if (x != 0) {
            return x;
        } else {
            return Long.valueOf(offset).compareTo(Long.valueOf(o.offset));
        }
    }


}
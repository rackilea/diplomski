public class SvgEncoder implements ResourceEncoder<SVG>{
    @NonNull
    @Override
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return EncodeStrategy.SOURCE;
    }

    @Override
    public boolean encode(@NonNull Resource<SVG> data, @NonNull File file, @NonNull Options options) {
        try {
            SVG svg = data.get();
            Picture picture = svg.renderToPicture();
            picture.writeToStream(new FileOutputStream(file));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
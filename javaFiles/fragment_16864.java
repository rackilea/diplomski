// write
out.writeBoolean(value != null);
if (value != null) {
  out.writeDouble(value);
}

// read
if (in.readBoolean()) {
  value = in.readDouble();
} else {
  value = null;
}
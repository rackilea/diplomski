if (inQuotes) {
            if (multi) {

                // continuing a quoted section, re-append newline

                sb.append("\n");

                pending = sb.toString();

                sb = null; // this partial content is not to be added to field list yet
            } else {
                throw new IOException("Un-terminated quoted field at end of CSV line");

            }
        }
long start = SystemClock.elapsedRealtime();

                int ch;
                int line = Integer.parseInt(editText.getText().toString().trim());
                if (line < 1 || line >= mLines.length ) {
                    mTextView.setText("invalid line: " + line + 1);
                }
                line--;
                int index = (line / MULTIPLE);
                in.skip(mLines[index]);
                int rem = line % MULTIPLE;
                while (rem > 0) {
                    ch = in.read();
                    if (ch == -1) {
                        return; // readLine will fail
                    } else if (ch == '\n' || ch == '\r') {
                        rem--;
                    }
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String text = reader.readLine();

                long elapsed = SystemClock.elapsedRealtime() - start;
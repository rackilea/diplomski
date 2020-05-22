// Create a TextView to add date
                TextView author = new TextView(this);
                author.setText(authorName);
                author.setPadding(2, 0, 5, 0);
                author.setTextColor(Color.BLACK);
                author.setHorizontalScrollBarEnabled(false);
                author.setWidth(150); // good idea to set width for author name so that its fixed
                tr.addView(author);

                TextView comment = new TextView(this);
                comment.setPadding(5, 0, 5, 0);
                comment.setText(bigComment);
                comment.setTextColor(Color.BLACK);
                comment.setMaxLines(10);

               // Provide this parameter so that the whole text can be seen with no cutoff
                comment.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT,1.0f));
                    tr.addView(comment);
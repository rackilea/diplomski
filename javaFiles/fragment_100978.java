CharSequence sequence = Html.fromHtml(article.getP(), this, null);
                SpannableStringBuilder stringBuilder = new SpannableStringBuilder(sequence);
                URLSpan[] urls = stringBuilder.getSpans(0, sequence.length(), URLSpan.class);
                for(URLSpan span : urls){
                    makeLinkClickable(stringBuilder, span);
                }
                contentNews.setText(stringBuilder);
                contentNews.setMovementMethod(LinkMovementMethod.getInstance());
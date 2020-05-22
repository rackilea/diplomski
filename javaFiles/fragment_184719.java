MappingTrackSelector.MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
                    if (mappedTrackInfo != null) {
                        int rendererIndex = 2;
                        int rendererType = mappedTrackInfo.getRendererType(rendererIndex);
                        boolean allowAdaptiveSelections =
                                rendererType == C.TRACK_TYPE_VIDEO
                                        || (rendererType == C.TRACK_TYPE_AUDIO
                                        && mappedTrackInfo.getTypeSupport(C.TRACK_TYPE_VIDEO)
                                        == MappingTrackSelector.MappedTrackInfo.RENDERER_SUPPORT_NO_TRACKS);
                        Pair<AlertDialog, TrackSelectionView> dialogPair =
                                TrackSelectionView.getDialog(xxxxxxxxxxxxxx.this, "Track Selector", trackSelector, rendererIndex);
                        dialogPair.second.setShowDisableOption(true);
                        dialogPair.second.setAllowAdaptiveSelections(allowAdaptiveSelections);
                        dialogPair.first.show();
                    }
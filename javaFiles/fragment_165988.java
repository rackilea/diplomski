IAudioResampler oggResampler = IAudioResampler.make(audioCoder.getChannels(), 
                                                   audioCoder.getChannels(), 
                                                   audioCoder.getSampleRate(),
                                                   audioCoder.getSampleRate(),  
                                                   IAudioSamples.Format.FMT_FLT, 
                                                   audioCoder.getSampleFormat());
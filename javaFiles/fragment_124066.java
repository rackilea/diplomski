module Main where


import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.List (foldl')
import Control.Monad.Primitive (PrimMonad, PrimState)
import Data.Vector.Generic (Vector)
import qualified Data.Vector.Unboxed as V
import qualified Data.Vector.Generic as G

import System.Random.MWC
import System.Random (randomRIO
                     ,getStdGen
                     ,randomRs
                     ,randomR
                     ,RandomGen)

import Criterion.Main

main :: IO ()
main = do let n = 1000000 ::Int -- 10^6
          defaultMain [
                    -- bench "loop1" $ whnfIO (loop1 n),
                    -- bench "loop2" $ whnfIO (loop2 n),
                    -- bench "loop3" $ whnfIO (loop3 n),
                    -- bench "loop4" $ whnfIO (loop4 n),
                       bench "loop5" $ whnfIO (loop5 n),
                       bench "loop6" $ whnfIO (loop6 n),
                       bench "loop7" $ whnfIO (loop7 n),
                       bench "moop5" $ whnfIO (moop5 n),
                       bench "moop6" $ whnfIO (moop6 n)]

loop1 ::  Int -> IO Int
loop1 n = do rs <- replicateM n (randomRIO (0,1)) :: IO [Double]
             return . length . filter (==True) $ map (<=0.5) rs

loop2 ::  Int -> IO Int
loop2 n = do rs <- replicateM n (randomRIO (0,1)) :: IO [Double]
             return $ foldl' (\x y -> x + round y) 0 rs


loop3 ::  Int -> IO Int
loop3 n = loop n 0 (randomRIO (0,1))
        where loop :: Int -> Int -> IO Double -> IO Int
              loop n' acc x | n' <=0    = round <$> x
                            | otherwise = do x' <- x
                                             loop (n'-1) (round x' + acc) x

loop4 ::  Int -> IO Int
loop4 n = loop n 0 (randomRIO (0,1))
        where loop :: Int -> Int -> IO Double -> IO Int
              loop n' acc x | n'<0     = return acc
                           | otherwise = do x' <- round <$> x
                                            let x'' = (x' + acc) in x'' `seq` loop (n'-1) x'' x

loop5 ::  Int -> IO Int
loop5 n = do g <- getStdGen
             return . sum . take n $ randomRs (0,1::Int) g

loop6 ::  Int -> IO Int
loop6 n = do g <- getStdGen
             return $ loop 0 n g
        where loop ::  (RandomGen t) => Int -> Int -> t -> Int
              loop acc n' g | n'<0       = acc
                            | otherwise = let (m,g') = randomR (0,1::Int) g
                                              acc' = acc + m
                                          in acc' `seq` loop acc' (n'-1) g'

loop7 ::  Int -> IO Int
loop7 n = do g <- getStdGen
             return $ loop 0 n g
        where loop ::  (RandomGen t) => Int -> Int -> t -> Int
              loop acc n' g | n'<0       = acc
                            | otherwise = let (m,g') = randomR (0,1::Double) g
                                              acc' = acc + round m
                                          in acc' `seq` loop acc' (n'-1) g'

moop5 :: Int -> IO Int
moop5 n = do vs <- withSystemRandom . asGenST $ \gen -> uniformVectorR (0,1) gen n
             return . V.sum $ V.map round (vs :: V.Vector Double)


moop6 :: Int -> IO Int
moop6 n = do vs <- withSystemRandom . asGenST $ \gen -> uniformVectorR (0,1) gen n
             return $ V.sum  (vs :: V.Vector Int)

-- Helper functions ------------------------------------------------------------

report :: Int -> Int -> String -> IO ()
report n m msg = putStrLn $ msg ++ "\n" ++
                           "True: "  ++ show (    m//n :: Double) ++ ", "++
                           "False: " ++ show ((n-m)//n :: Double)

(//) :: (Integral a, Fractional b) => a -> a -> b
x // y = fromIntegral x / fromIntegral y

uniformVectorR :: (PrimMonad m, Variate a, Vector v a) =>
                  (a, a) -> Gen (PrimState m) -> Int -> m (v a)
uniformVectorR (lo,hi) gen n = G.replicateM n (uniformR (lo,hi) gen)
{-# INLINE uniformVectorR #-}